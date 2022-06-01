from selenium import webdriver
import time

driver = webdriver.Firefox()
driver.get("https://www.baidu.com/")
# 浏览器的最大化
# driver.maximize_window()
title = driver.title
print(title)
url = driver.current_url
print(url)
#设置浏览器的长和宽
driver.find_element_by_id("kw").send_keys("王牌部队")
driver.find_element_by_id("su").click()
driver.maximize_window()
time.sleep(3)
driver.set_window_size(400, 1000)
time.sleep(3)
#操作浏览器的前进和后退
# 浏览器后退
# driver.back()
# time.sleep(8)
# # # 浏览器前进
# driver.forward()
time.sleep(8)
# 浏览器滚动条的控制
js0 = "var q=document.documentElement.scrollTop=10000"
driver.execute_script(js0)
time.sleep(3)
js1 = "var q=document.documentElement.scrollTop=0"
driver.execute_script(js1)

time.sleep(8)
driver.quit()

