node {
	properties([
		// Below line sets "Discard Builds more than 5"
		buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '5')), 
		
		// Below line triggers this job every minute
		pipelineTriggers([pollSCM('* * * * *')])
		])
	stage("Pull Repo"){
		git   'https://github.com/farrukh90/cool_website.git'
	}
	stage("Install Prerequisites"){
		sh """
		ssh centos@dev1.cyber-pro.org                  sudo yum install httpd -y
		"""
	}
	stage("Copy artifacts"){
		sh """
		scp -r *  centos@dev1.cyber-pro.org:/tmp
		ssh centos@dev1.cyber-pro.org                 sudo cp -r /tmp/index.html /var/www/html/
		ssh centos@dev1.cyber-pro.org                sudo cp -r /tmp/style.css /var/www/html/
		ssh centos@dev1.cyber-pro.org			   sudo chown centos:centos /var/www/html/
		ssh centos@dev1.cyber-pro.org			   sudo chmod 777 /var/www/html/*
		"""
	}
	stage("Restart web server"){
		sh "ssh centos@dev1.cyber-pro.org                 sudo systemctl restart httpd"
	}
	stage("Slack"){
		slackSend color: '#BADA55', message: 'Hello, World!'
	}
}