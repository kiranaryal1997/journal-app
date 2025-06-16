# journal-app
The Journal App is a secure and scalable RESTful web application built using Java Spring Boot. It enables users to create, read, update, and delete (CRUD) personal journal entries. The application is designed with a focus on clean architecture, security, testability, and maintainability. 

## Public
POST /public/create-user — Create user (Public)

User (Authenticated)
PUT /user — Update user (Auth)

GET /journal — Get all journals (Auth)

POST /journal — Create journal (Auth)

GET /journal/id/{id} — Get journal by ID (Auth)

PUT /journal/id/{id} — Update journal by ID (Auth)

DELETE /journal/id/{id} — Delete journal by ID (Auth)

Admin (Authorized)
GET /admin/all-users — Get all users (Admin)

POST /admin/create-admin-user — Create admin user (Admin)
