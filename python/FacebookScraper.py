# import requests
# from bs4 import BeautifulSoup as bs
# import json
# import time

# def scrape_facebook_post(url, email, password):
#     scraped_data = []

#     headers = {
#         'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.3'
#     }
    
#     login_data = {
#         'email': email,
#         'pass': password
#     }
    
#     response = requests.post('https://www.facebook.com/login.php?login_attempt=1', headers=headers, data=login_data)
#     print(response.status_code)
    
#     if response.status_code == 200:
#         response = requests.get(url, headers=headers)
#         soup = bs(response.content, 'html.parser')
#         comments = soup.find_all('div', {'class': 'x1y1aw1k xn6708d xwib8y2 x1ye3gou'})
#         for comment in comments:
#             comment_text = comment.find('div', {'dir': 'auto', 'style': 'text-align: start;'}).text
#             scraped_data.append({"comment": comment_text})
#             print(comment_text)
#         return scraped_data
#     else:
#         return []

# email = "suka.enelpe@gmail.com"
# password = "Sukanlp123."
# url = "https://www.facebook.com/Jokowi/posts/pfbid02jgR76SqznUiUj9SXTSFpS9756AdStUug1VPnbgguG5ALrMm3VeUzSjhRuyGRzr2il"
# scraped_data = scrape_facebook_post(url, email, password)
# print(scraped_data)

import facebook_scraper

def scrape_comments(post_url):
    page_url = post_url.split("/")[3]
    posts = facebook_scraper.get_posts(page_url, pages=10, options={"comments": True})
    for post in posts:
        if post["post_url"] == post_url:
            print(post["post_url"])
            comments = [{"text": comment["text"], "username": comment["username"]} for comment in post["comments_full"]]
            return comments
    return []

post_url = "https://www.facebook.com/Jokowi/posts/pfbid02jgR76SqznUiUj9SXTSFpS9756AdStUug1VPnbgguG5ALrMm3VeUzSjhRuyGRzr2il"
comments = scrape_comments(post_url)
print(comments)