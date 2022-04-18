provider "aws" {
  region     = "ap-south-1"
  // access_key = var.access_key
  // secret_key = var.secret_key
}

resource "aws_instance" "Manager" {
  ami             = var.ami
  instance_type   = var.instance_type
  key_name = "${var.key_name}"
  vpc_security_group_ids = ["${aws_security_group.micro_service_app_sg.id}"]
  user_data = "${file("${var.bootstrap_path}")}"
  tags = {
    Name = "Manager_Docker_Swarm"
  } 
  # provisioner "file" {
  #   source      = "./docker-compose-swarm.yml"
  #   destination = "./docker-compose-swarm.yml"

  #   connection {
  #     type        = "ssh"
  #     user        = "ubuntu"
  #     private_key = "${file("${var.key_path}")}"
  #     host        = "${self.public_dns}"
  #   }
  # }
}

resource "aws_instance" "Worker_01" {
  ami             = var.ami
  instance_type   = var.instance_type
  key_name = "${var.key_name}"
  vpc_security_group_ids = ["${aws_security_group.micro_service_app_sg.id}"]
  user_data = "${file("${var.bootstrap_path}")}"
  tags = {
    Name = "Worker01_Docker_Swarm"
  }
}

resource "aws_instance" "Postgres_instance" {
  ami             = var.ami
  instance_type   = var.instance_type
  key_name = "${var.key_name}"
  vpc_security_group_ids = ["${aws_security_group.micro_service_app_sg.id}"]
  user_data = "${file("${var.bootstrap_path}")}"
  tags = {
    Name = "Postgres_instance"
  }
}

resource "aws_security_group" "micro_service_app_sg" {
  name        = "micro_service_app_sg"
  description = "Security_Group"
  ingress {
    from_port   = 22
    protocol    = "tcp"
    to_port     = 22
    cidr_blocks = ["0.0.0.0/0"]
  }
  ingress {
    from_port   = 2377
    protocol    = "tcp"
    to_port     = 2377
    cidr_blocks = ["0.0.0.0/0"]
  }
  ingress {
    from_port   = 7946
    protocol    = "tcp"
    to_port     = 7946
    cidr_blocks = ["0.0.0.0/0"]
  }  
  ingress {
    from_port   = 7946
    protocol    = "udp"
    to_port     = 7946
    cidr_blocks = ["0.0.0.0/0"]
  }
  ingress {
    from_port   = 4789
    protocol    = "udp"
    to_port     = 4789
    cidr_blocks = ["0.0.0.0/0"]
  }
  ingress {
    from_port   = 8081
    protocol    = "tcp"
    to_port     = 8081
    cidr_blocks = ["0.0.0.0/0"]
  }
  ingress {
    from_port   = 8082
    protocol    = "tcp"
    to_port     = 8082
    cidr_blocks = ["0.0.0.0/0"]
  }
  ingress {
    from_port   = 5432
    protocol    = "tcp"
    to_port     = 5432
    cidr_blocks = ["0.0.0.0/0"]
  }  
  egress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
  egress {
    from_port   = 8081
    to_port     = 8081
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }
  egress {
    from_port   = 8081
    to_port     = 8081
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }
  egress {
    from_port   = 8080
    to_port     = 8080
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

}

resource "null_resource" "postgres_install" { 
  provisioner "local-exec" {
	command = <<EOT
    sleep 600;
	  >postgres.ini;
	  echo "[postgresql]" | tee -a postgres.ini;
	  echo "${aws_instance.Postgres_instance.public_ip} ansible_ssh_private_key_file=${var.key_path}" | tee -a postgres.ini;
    EOT
  }
}

resource "null_resource" "docker_swarm" { 
  provisioner "local-exec" {
	command = <<EOT
    sleep 600;
	  >docker_swarm.ini;
	  echo "[masters]" | tee -a docker_swarm.ini;
	  echo "${aws_instance.Manager.public_ip} ansible_ssh_private_key_file=${var.key_path}" | tee -a docker_swarm.ini;
    echo "[workers]" | tee -a docker_swarm.ini;
	  echo "${aws_instance.Worker_01.public_ip} ansible_ssh_private_key_file=${var.key_path}" | tee -a docker_swarm.ini;
    EOT
  }
}
