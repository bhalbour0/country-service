# Country Service

## Installation and Run

This is the backend server for the country service code assignement.

To get the server up and running: 

### Install the git client (if needed)
  
  Please refer to [Install Git](https://github.com/git-guides/install-git) if you don't already have git locally.
  
### Download and install the project
  
  Go into your folder, then run :
  
  `git clone https://github.com/bhalbour0/country-service.git`
  
### Build the project

To build the project from sources, go inside the country-service folder, then run: 

  `./mvnw clean install`

### Run the project

As the jar file was generated in the previous command, you can run the project with: 
  
  `./mvnw spring-boot:run`
  
You should see the server running in your terminal at http://localhost:8080.
  
## Usage 

This server expose to REST API:

- */countries*: Return several countries from this external API: https://restcountries.com/v3.1/all.
- */countries/{name}*: Another one which return details of one country from this external API: https://restcountries.com/v3.1/name/{name}

This server could be used with [the web application](https://github.com/bhalbour0/country-client)
