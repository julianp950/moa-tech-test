# Tech Test
 
# Installation
For starters, obtain `www.zip` and `backend-0.0.1-SNAPSHOT.jar` from the [demo release](https://github.com/julianp950/moa-tech-test/releases/tag/0.0.1).

## Frontend
Unzip the contents of `www.zip` in your preferred folder and deploy locally. You can use [http-server](https://www.npmjs.com/package/http-server) for this.

## Database
This project utilizes **[PostgreSQL 13](https://www.postgresql.org/)** and requires to be initialized as such:
* Use port 5432
* Create a database named `moa`
* Create the following user with the instructed credentials and set it as owner of the database:
  * `user: admin`
  * `password: admin`

## Backend
The backend requires to be run using at least **[Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)**.

For execution of the backend simply run `backend-0.0.1-SNAPSHOT.jar`.

It is suggested to do so with the following terminal command for a verbose monitoring: `java -jar ./backend-0.0.1-SNAPSHOT.jar`.
