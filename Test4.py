from selenium import webdriver
import time

driver = webdriver.Firefox()
driver.get("https://www.baidu.com/")
driver.maximize_window()

#
driver.find_element_by_id("kw").send_keys("肖战")
driver.find_element_by_id("su").click()
# 固定等待
# time.sleep(10)
#智能等待
driver.implicitly_wait(10)
driver.find_element_by_link_text("百度百科").click()
time.sleep(6)
driver.quit()
