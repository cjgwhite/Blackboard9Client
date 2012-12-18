Blackboard9Client
=================

Blackboard Learn 9 Client based on JaxWS.

I found that in a multi-threaded and multi-user environment the Blackboard provided axis based client causes significant service problems due to an issue with the version of RAMPART that it required. To overcome these issues I developed this JaxWS based client.

To build you will need to have an accessible Blackboard 9 service. Modify the POM properties...

    <properties>
        <bb9.host></bb9.host>
        <bb9.protocol>https</bb9.protocol>
    </properties>
    
... with the relevant information for your Blackboard Service.


THe project provides two Spring context XML files...

  Blackboard.xml
  BlackboardAutoRegisterTool.xml
  
The first provides the basic configuration for the client. The second provides a single bean that will try and
automatically register the Proxy Tool with the Blackboard service.

There are some configuration Properties that need to be set within your application -- check out the two XML files 
for the placeholders.

A login needs to be performed before any attempt to use any method provided by the webservices. This can be achieved by 
using one of the login methods on the CLientWrapper object. For ProxyTools this would be the loginTool() method.

