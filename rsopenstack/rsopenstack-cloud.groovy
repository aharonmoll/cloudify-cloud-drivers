
cloud {
	name = "rackspace"
	configuration {
		className "org.cloudifysource.esc.driver.provisioning.openstack.RSCloudDriver"
		managementMachineTemplate "SMALL_LINUX"
		connectToPrivateIp true
	}

	provider {
		provider "rackspace"
		localDirectory "tools/cli/plugins/esc/rsopenstack/upload"
		
		cloudifyUrl "http://repository.cloudifysource.org/org/cloudifysource/2.1.1/gigaspaces-cloudify-2.1.1-ga-b1396-361.zip" 
		//The machineNamePrefix property may not contain the char '_' in Rackspace
		machineNamePrefix "agent"
		
		dedicatedManagementMachines true
		managementOnlyFiles ([])
		
		//The managementGroup property may not contain the char '_' in Rackspace
		managementGroup "management"
		numberOfManagementMachines 1
		zones (["agent"])
		reservedMemoryCapacityPerMachineInMB 1024
		
		sshLoggingLevel "WARNING"
		
	}
	user {
		user "USER_NAME"
		apiKey "API_KEY"
	}
	templates ([
				SMALL_LINUX : template{
					imageId "118"
					machineMemoryMB 1600
					hardwareId "4"
					remoteDirectory "/root/gs-files"
					
				}
			])
			
	custom ([
		"openstack.endpoint" : "https://servers.api.rackspacecloud.com",
		"openstack.identity.endpoint": "https://auth.api.rackspacecloud.com/",
		"openstack.tenant" : "ENTER_TENANT",
		"openstack.wireLog": "false"

	])
}

