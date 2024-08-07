# UserName Checker on Flask.
import requests
import colorama
from flask import Flask, json, jsonify

def cek_socmed(name):

	websites = {
	"Facebook": "https://facebook.com/",					# For Facebook	
	"Twitter": "https://twitter.com/",						# For Twitter
	"Github": "https://github.com/",						# For Github
	"Instagram": "https://instagram.com/",					# For Instagram	
	"Devpost": "https://devpost.com/",						# For DevPost
	"LinkedIn": "https://linkedin.com/in/",					# For LinkedIn
	"Google Plus": "https://plus.google.com/+",				# For Google Plus
	"About.me": "https://about.me/",						# For About.me
	"Disqus": "https://disqus.com/by/",						# For Disqus
	"YouTube": "https://youtube.com/",						# For YouTube
	"Flickr": "https://flickr.com/people/",					# For Flickr
	"Dribble": "https://dribble.com/",						# For Dribble
	"Behance": "https://behance.net/",						# For Behance
	"DeviantArt": "https://deviantart.com/"			     	# For DeviantArt
	}


	responses = [False, True]

	name = name
	data = {} # Creating a dictionary to store data.

	# Sending Requests to websites.
	example_headers = {'User-Agent':'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.71 Safari/537.36'}
	for web, link in websites.items():
		r = requests.get(link + name, headers=example_headers)
		if  r.status_code == 200:
			data[web] = responses[0]
			#print(web + ": " + responses[0])
				
		elif r.status_code == 404:
			data[web] = responses[1]
			#print(web + ": " + responses[1])
		else:
			data[web] = r.status_code
			#print(web + ": " + str(r.status_code) + " => error")

	jsonStr = json.dumps(data)
	#return jsonify(DATA=jsonStr)
	print(jsonStr)		
	#return str(data)
 
if __name__ == "__main__":
    cek_socmed("denny.afrizal@aleph-labs.com")