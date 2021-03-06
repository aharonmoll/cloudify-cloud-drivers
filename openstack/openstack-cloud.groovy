
cloud {
	// Mandatory. The name of the cloud, as it will appear in the Cloudify UI.
	name = "Openstack"
	configuration {
		// Mandatory - openstack Diablo cloud driver.
		className "org.cloudifysource.esc.driver.provisioning.openstack.OpenstackCloudDriver"
		// Optional. The template name for the management machines. Defaults to the first template in the templates section below.
		managementMachineTemplate "SMALL_LINUX"
		// Optional. Indicates whether internal cluster communications should use the machine private IP. Defaults to true.
		connectToPrivateIp true
	}

	provider {
		// optional 
		provider "openstack"
		localDirectory "tools/cli/plugins/esc/openstack/upload"
		
		cloudifyUrl "http://repository.cloudifysource.org/org/cloudifysource/2.1.1/gigaspaces-cloudify-2.1.1-ga-b1396-361.zip" 
		machineNamePrefix "cloudify_agent_"
		
		dedicatedManagementMachines true
		managementOnlyFiles ([])
		
		managementGroup "cloudify_manager"
		numberOfManagementMachines 1
		zones (["agent"])
		reservedMemoryCapacityPerMachineInMB 1024
		
		sshLoggingLevel "WARNING"
		
		
	}
	user {
		user "ENTER_USER"
		apiKey "ENTER_API_KEY"
		keyFile "ENTER_KEY_FILE"
	}
	templates ([
				SMALL_LINUX : template{
                    imageId "1234"
					machineMemoryMB 3200
					hardwareId "103"
					remoteDirectory "/root/gs-files"					
					options ([
						"openstack.securityGroup" : "default",
						"openstack.keyPair" : "ENTER_KEY_PAIR_NAME"
					])
					
				}
			])
			
	custom ([
		"openstack.endpoint" : "https://az-1.region-a.geo-1.compute.hpcloudsvc.com/",
		"openstack.identity.endpoint": "https://region-a.geo-1.identity.hpcloudsvc.com:35357/",
        "openstack.tenant" : "ENTER_TENANT",
		"openstack.wireLog": "false"

	])
}

