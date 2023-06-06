# Trino Connector
Project carried out by IT students of the Poznan University of Technology in cooperation with IBM.
## What went well:
 - Using the SDK provided by IBM we generated a new connector
 - We have defined the connection properties according to Trino's documentation for connector's discovery feature
 - We have succesfully build a docker image of our connector and flight service
 - We have succesfully connected with our service via the Jupyter notebook provided to us
 - We have succesfully performed a discovery of connection properties
## Obstacles:
- We had a number of issues with gradle scripts for building and starting docker images mostly concerning onlyIf clauses.
- We had a problem with building a docker image after adding TrinoJDBC classes
- The SDK is somewhat hard to understand and finding out where and how to implement things is pretty challenging
