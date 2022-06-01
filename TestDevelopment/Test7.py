from selenium import webdriver
import time
from selenium.webdriver.common.keys import Keys

driver = webdriver.Chrome()
driver.get("http://127.0.0.1:88/zentao/user-login-L3plbnRhby8=.html")
# 浏览器的最大化
driver.maximize_window()
time.sleep(3)
# 清楚已有账号的登录信息
driver.find_element_by_id("account").clear()
driver.find_element_by_name("password").clear()
# 登陆操作

driver.find_element_by_id("account").send_keys("admin")
# 使用tab键将焦点定位到用户名
driver.find_element_by_id("account").send_keys(Keys.TAB)
time.sleep(4)
driver.find_element_by_name("password").send_keys("huiwen890830")

# driver.find_element_by_id("submit").click()
# 用Enter键直接登陆
driver.find_element_by_name("password").send_keys(Keys.ENTER)
time.sleep(6)
driver.quit()