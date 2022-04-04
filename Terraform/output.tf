output "master_public_ip" {
    value = ["${aws_instance.Manager.public_ip}"]
    
}
output "worker1_public_ip" {
    value = ["${aws_instance.Worker_01.public_ip}"]
}
 