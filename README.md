# hazelcast-lab

Testing a distributed application in a realistic environment with multiple hosts over a network is a hassle, 
and not easy to do in a development environment with requirements for simple, robust, reproducible tests 
with a really quick turnaround. This simple example project, shows how to set up a light-weight test framework, 
based on Docker and Docker Compose, that enables automated, self-contained and stateless testing of a distributed software, 
and that can be easily deployed and maintained on a developer laptop. It is demonstrated how to emulate scenarios 
with multiple network interfaces, host crash/restart, and network partition.

For more info, read my blog post: [https://mxns.github.io/unit-testing-a-distributed-service/](https://mxns.github.io/unit-testing-a-distributed-service/)
