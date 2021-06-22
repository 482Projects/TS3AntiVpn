# TS3AntiVpn
You can use the bot to check a client IP if it is a VPN it will be banned/kicked config dependent

# Features
- Own Nickname
- Own Reason for disconnect
- You can switch between two providers at this time and more will be added in the future
- You can set whether the user will be banned or kicked

# The Story
Since many hosting providers offer this tool for sale, we thought that since many users have Teamspeak running on their own root server anyway, we offer it open source, you do not need any programming skills because you just have to adjust the settings in the config. 

# Infos 

We kindly ask you not to use our projects for commercial purposes.

## Install

### Download
- [![Download](https://img.shields.io/badge/Download-latest-orange.svg)](https://github.com/482Projects/TS3AntiVpn/archive/refs/tags/1.0.zip)
#### Linux **Ubuntu & Debian**:  
Install Java

```sh
sudo apt update
```
```sh
sudo apt upgrade
```
```sh
sudo apt install default-jre
```
```sh
java -version
```
Download the Emulator
```sh
mkdir /home/TS3AntiVPN
cd /home/TS3AntiVPN
wget https://github.com/482Projects/TS3AntiVpn/releases/download/1.0/TS3AntiVPN-linux.zip
```
Install the Emulator
```sh
unzip TS3AntiVPN-linux.zip
```

About The Config.json
```
"host": The Teamspeak Host Address
"port": The Teamspeak Port
"queryusername": The Teamspeak Query Username
"querypassword": The Teamspeak Query Password
"querynickname": The Nickname of the Bot
"banorkick": Please specify if the client should be kicked or banned kick or ban
"reason": The Reason when the client get kicked or banned

"service": The service GetIpIntel can be used without registration you only have to provide an email for the service GetIpHub you have to create an account on https://iphub.info/register and generate the API free API Token more services will follow in the next version
"email": The e-mail for the GetIpIntel service must be filled in if you want to use the service.
"apikey": The API Key for the GetIpHub Service 
"debug": Log
````
Check The Config.json
```json
{
"host": "yourteamspeakaddress.de",
"port": "9987",
"queryusername": "serveradmin",
"querypassword": "querypassword",
"querynickname": "AntiVpn",
"banorkick": "kick",
"reason": "VPN Blocker",

"service": "GetIpIntel",
"email": "yourmail@example.com",
"apikey": "youapikey",
"debug": "false"
}

```
Run the Bot
- ```sh bash start.sh ``` 
 
For Screen:
- ```sh bash start-screen.sh ```


---
Visit [482Projects](https://482-projects.com)
---
[![forthebadge](http://forthebadge.com/images/badges/60-percent-of-the-time-works-every-time.svg)](https://482-projects.com) [![forthebadge](http://forthebadge.com/images/badges/built-by-developers.svg)](https://482-projects.com) [![forthebadge](http://forthebadge.com/images/badges/built-with-love.svg)](https://482-projects.com) [![forthebadge](http://forthebadge.com/images/badges/contains-cat-gifs.svg)](https://482-projects.com) [![forthebadge](http://forthebadge.com/images/badges/made-with-java.svg)](https://482-projects.com)
