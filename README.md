# Country Service

## Installation and Run

This is the backend server for the country service code assignement.

To get the server up and running: 

### Install the git client
  
  Please refer to [Install Git](https://www.example.com) if you don't already have git locally.
  
### Download and install the project
  
  Go into your folder, then run :
  
  `git clone https://github.com/bhalbour0/country-service.git`
  
### To start up the server, open up a terminal inside the country-service folder, then run this command:
  
  `./mvnw spring-boot:run`
  
  You should see the server running in your terminal at http://localhost:8080.
  
## Usage 

This server expose to REST API:

- One which get several countries from this external API: https://restcountries.com/v3.1/all
- Another one which return details of one countru from this external API: https://restcountries.com/v3.1/name/{name}

This server could be used with [the web application](https://github.com/bhalbour0/country-client)
