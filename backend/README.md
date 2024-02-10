# Read Me First

## Steps to connect to DB

1. Install MS SQL Server from [here](https://go.microsoft.com/fwlink/p/?linkid=2215158&clcid=0x409&culture=en-us&country=us)
2. Install MS SQL Management Studio from [here](https://aka.ms/ssmsfullsetup)
3. Create a Database named "Novelty"
4. Create a user named "novelty", with password "novelty". [Instructions to create user](https://www.guru99.com/sql-server-create-user.html)
5. Give the user access and make server accessible with SQL credentials. [Instructions](https://www.youtube.com/watch?v=-UY0fHckkGc&ab_channel=SachinSamy)
6. Enable TCP/IP access [like this](https://help.dugeo.com/m/Insight/l/438913-troubleshooting-enabling-tcp-ip-in-the-sql-server)
7. Remove locks preventing the user to access the DB [like this](https://stackoverflow.com/questions/19334041/the-select-permission-was-denied-on-the-object-users-database-xxx-schema)
7. Run server