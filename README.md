Instructions:

1. Docerfile change path if it needs to customize:
now: "-Dfile.dir=prices" - link to the directory of files

2. build Docker Image and up docker compose

3. Application will upload all the files and its will keep metadate about files (if you put the path to directory correctly)
   By defaults there are 5 files in /prices
4. The app will make migration in order to cfreate some functions and tables in public schema (Postgres) 

5. Documentation swagger will be available by link:
http://localhost:8080/swagger-ui/index.html


