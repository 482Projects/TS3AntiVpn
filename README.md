# TS3AntiVpn
You can use the bot to check a client IP if it is a VPN it will be banned/kicked config dependent

# The Story
Since many hosting providers offer this tool for sale, we thought that since many users have Teamspeak running on their own root server anyway, we offer it open source, you do not need any programming skills because you just have to adjust the settings in the config. 

# Infos 

We kindly ask you not to use our projects for commercial purposes.

## Install

### Download
- [![Download](https://img.shields.io/badge/Download-latest-orange.svg)](#)
- [![Download](https://img.shields.io/badge/Download-beta-orange.svg)](#)

#### Linux **Ubuntu & Debian**:  
Install Java

```sh
$ sudo apt update
$ sudo apt upgrade
$ sudo apt install default-jre
$ java -version
```
Download the Emulator
```sh
$ wget .
$ wget .
```
Check The Config.json
```json
{
"host": "yourteamspeakaddress.de", The Teamspeak Host Address
"port": "9987", The Teamspeak Port
"queryusername": "serveradmin", The Teamspeak Query Username
"querypassword": "querypassword", The Teamspeak Query Password
"querynickname": "AntiVpn", The Nickname of the Bot
"banorkick": "kick", Please specify if the client should be kicked or banned "kick" or "ban"
"reason": "VPN Blocker", The Reason when the client get kicked or banned
"randomchars": "abcxyz", Its for the Name: AntiVpn [a,b,c,x,y,z]

"service": "GetIpIntel", The service GetIpIntel can be used without registration you only have to provide an email for the service GetIpHub you have to create an account on https://iphub.info/register and generate the API free API Token more services will follow in the next version
"email": "yourmail@example.com", The e-mail for the GetIpIntel service must be filled in if you want to use the service.
"apikey": "youapikey" The API Key for the GetIpHub Service 
}

```
Run the Bot
```sh
$ java -jar Bot.jar
```


---
Visit [[482Projects]](https://482-projects.com)
---
[![forthebadge](http://forthebadge.com/images/badges/60-percent-of-the-time-works-every-time.svg)](https://482-projects.com) [![forthebadge](http://forthebadge.com/images/badges/built-by-developers.svg)](https://482-projects.com) [![forthebadge](http://forthebadge.com/images/badges/built-with-love.svg)](https://482-projects.com) [![forthebadge](http://forthebadge.com/images/badges/contains-cat-gifs.svg)](https://482-projects.com) [![forthebadge](http://forthebadge.com/images/badges/made-with-java.svg)](https://482-projects.com)
