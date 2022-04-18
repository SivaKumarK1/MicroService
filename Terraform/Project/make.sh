#!/bin/bash -ex

# terraform changes to instances
terraform validate

terraform init

terraform plan

terraform apply  --auto-approve

terraform output | grep -o '(\d+[.]){3}\d+' > ips

#change master ip in hosts file
rm temp.txt
sed -i "s/$(awk 'FNR == 2' inventory/hosts > temp.txt && awk '{print $1}' temp.txt)/$(awk "FNR == 2" ips)/g" inventory/hosts
ls
# change worker ip in hosts file
rm temp.txt
sed -i "s/$(awk 'FNR == 4' inventory/hosts > temp.txt && awk '{print $1}' temp.txt)/$(awk "FNR == 3" ips)/g" inventory/hosts
ls
# change postgres ip in hosts file
rm temp.txt
sed -i "s/$(awk 'FNR == 6' inventory/hosts > temp.txt && awk '{print $1}' temp.txt)/$(awk "FNR == 1" ips)/g" inventory/hosts
ls

sleep 1m
# # Running ansible
# export ANSIBLE_HOST_KEY_CHECKING=False

# ansible-playbook -i inventory/hosts playbook.yml

rm ips  temp.txt

cat inventory/hosts
