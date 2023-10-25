# Tech Test

## Description
A simple CRUD app for users in a system. Created users by the app can log into the app itself and do actions according to their established role.

Available roles:
* admin: can create, edit and delete users except itself.
* user: can edit users.
* viewer: can only view created users.

For DEMO purposes the following users are accessible from the get-go:
* admin
  * `user: admin`
  * `password: admin`
* user
  * `user: user`
  * `password: user`
* viewer
  * `user: viewer`
  * `password: viewer`
 
## Installation
For starters, obtain `www.zip` and `backend-0.0.1-SNAPSHOT.jar` from the [demo release](https://github.com/julianp950/moa-tech-test/releases/tag/0.0.1).

### Frontend
Unzip the contents of `www.zip` in your preferred folder and deploy locally. You can use [http-server](https://www.npmjs.com/package/http-server) for this.

### Database
This project utilizes **[PostgreSQL 13](https://www.postgresql.org/)** and requires to be initialized as such:
* Use port 5432
* Create a database named `moa`
* Create the following user with the instructed credentials and set it as owner of the database:
  * `user: admin`
  * `password: admin`

### Backend
The backend requires to be run using at least **[Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)**.

For execution of the backend simply run `backend-0.0.1-SNAPSHOT.jar`. It is suggested to do so with the following terminal command for a verbose monitoring: `java -jar ./backend-0.0.1-SNAPSHOT.jar`.

The backend service is expected to run at port 8080.
