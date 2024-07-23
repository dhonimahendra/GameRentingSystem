# GameRentingSystem
Task:
Create a RESTful web service for the following use case. 
Create a game renting system that is capable of adding new games, removing games and allowing a member to loan or return a game. Each game needs a title, studio and genre.
Rules:
Maximum games loaned at any time to a user is 3. If a user has loaned 3, unless the user returns at least one game, the user can't loan anymore.
There can only be one copy of each game (a combination of title and studio).
A game has at least one genre
Consider the user to be already authenticated

Technologies Used
Backend Framework: Spring Boot
Database: PostgreSQL (psql)
Build Tool: Gradle

API Endpoints:
Game Management

Add or Update a Game
POST /games
Request Body:
json
{
  "title": "Game Title",
  "studio": "Game Studio",
  "genres": ["Genre1", "Genre2"]
}
Response:
json
{
  "id": 1,
  "title": "Game Title",
  "studio": "Game Studio",
  "genres": ["Genre1", "Genre2"]
}

Get All Games

GET /games
Response:
json
Copy code
[
  {
    "id": 1,
    "title": "Game Title",
    "studio": "Game Studio",
    "genres": ["Genre1", "Genre2"]
  }
]

Remove a Game:
DELETE /games/{id}
Response:
json
"Game 'God of War' by Santa Monica Studio was deleted successfully."

Member Management
Add a Member

POST /members
Request Body:
json
{
  "name": "Dhoni"
}
Response:
json
{
  "id": 1,
  "name": "Dhoni"
}

Get All Members

GET /members
Response:
json
[
  {
    "id": 1,
    "name": "Member Name"
  }
]
Remove a Member

DELETE /members/{id}
Response:
json
"Member "Dhoni" was deleted Successfully."

**Loaning and Returning Games**

**Loan Game**
URL: /members/{memberId}/loan/{gameId}
Method: POST
Path Variables:
memberId - ID of the member
gameId - ID of the game to be loaned
Response:
json
{
  "id": 1,
  "name": "Dhoni",
  "loanedGames": [
    {
      "id": 1,
      "title": "Game Title",
      "studio": "Game Studio",
      "genres": ["Genre1", "Genre2"]
    }
  ]
}


**Return Game**
URL: /members/{memberId}/return/{gameId}
Method: POST
Path Variables:
memberId - ID of the member
gameId - ID of the game to be returned
Response:
json
{
  "id": 1,
  "name": "Dhoni",
  "loanedGames": [
    {
      "id": 1,
      "title": "Game Title",
      "studio": "Game Studio",
      "genres": ["Genre1", "Genre2"]
    }
  ]
}


**Running the Project**
Clone the Repository:
git clone https://github.com/dhonimahendra/gamerentingsystem.git

cd gamerentingsystem

Build the Project:

./gradlew build

Run the Application:

./gradlew bootRun

Access the Application:

Open your browser and go to http://localhost:8080.


