node { 

properties([
    // Below line sets "Discard Vuild more than 5"
    buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '5')), 
   // Below line triggers this job every minute
    pipelineTriggers([pollSCM('* * * * *')])
    ])


stage("Stage1"){ 

echo "hello" 

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

stage("Stage5"){ 

echo "hello" 

} 

} 
