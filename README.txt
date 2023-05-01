# Distributed Computing Systems

## Programming Project 4: Consistent Hashing-based Naming Service

### Members
1. Jaya Simha Reddy Kurri (jrk98933@uga.edu)
2. Shanwaz Waqar Kotekanti (sk98220@uga.edu)



#### special compilation or execution instruction


	# How to run
	
	## Run BootstrapServer

	bnConfig is the configuration file for the BootstrapServer
	
	Open The Terminal in the BootstrapServer directory and enter the below commands:


	```
	$ javac *.java 

	$ java BootstrapServer bnConfig

	```
	Upon startup the Bootstrap name server will manage the entire [0, 1023] range until other
	servers join the system.

	The Bootstrap name server will also provide a user interaction thread.
	The user interaction thread will support the following commands.


	lookup key : retrieves the value corresponding to the given key (if the key is in the
 	system). If the given key is not in the system, “Key not found” will be printed. In addition to the value, this commands will also printout the sequence of server IDs that were contacted and the ID of the server from which the final response was obtained.


	Insert key value : will insert the key value pair into the system. The command will print out the ID of the server into which the key value pair was inserted and the sequence of server IDS that were contacted.

	delete key : will delete the key value pair corresponding to the given key. If successfully deleted, “Successful deletion” will be printed. If key was not in the system “Key not found” will be printed. In addition, the sequence of server IDs that were contacted in the deletion process will be printed.


	### Run NameServers 

	nsConfig is the configuration file for the NameServer

	make sure that the ids for each NameServer are different
	
	Open another Terminal in the NameServer folder and enter the below commands:

	```
	
	$ javac *.java

	$ java NameServer nsConfig

	```

	Each name server has an ID (specified in the configuration file). Each name server is responsible for maintaining the key, value pairs for a specific range of keys as specified in the consistent hashing algorithm. Each name server knows its predecessor and successor name servers.

	Each name server will also provide a user interaction thread. The user interaction thread will support the following commands.


	enter :  The name server will enter into the system. This process is initiated by first contacting the Bootstrap server. It will figure out the range of the keys that it should maintain by following the consistent hashing protocol. It will acquire the key value pairs corresponding to its range from the name server that will become its successor name server. Once the entire entry procedure is complete, “successful entry” message is printed out. In addition, the following information is printed out: (1) The range of keys that will be managed by this server; (2) the ID of the predecessor and successor name servers; (3) the IDs of the servers that were traversed during the entry process.
	
	exit : The name server will gracefully exit the system. The name server will inform its successor and predecessor name servers. It will hand over the key value pairs that it was maintaining to the successor. Upon successful exit, the server will print “Successful exit” message. It will also print out the ID of the successor and the key range that was handed over.


###### Honor Pledge For Project

This project was done in its entirety by **Jaya Simha Reddy Kurri** and ** Shanwaz Waqar Kotekanti **. We hereby state that we have not received unauthorized help of any form.











