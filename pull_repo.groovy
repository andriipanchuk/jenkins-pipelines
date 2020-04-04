node { 

stage("Stage1"){ 
echo "hello" 
git 'https://github.com/farrukh90/packer.git'
} 
stage("Stage2"){ 
echo "hello" 

} 
stage("Stage3"){ 
echo "hello" 
} 

stage("Stage4"){ 
echo "hello" 

} 

stage("Send Notifications to Slack"){ 
slackSend color: '#BADA55', message: 'Hello, World!' 

} 

} 
