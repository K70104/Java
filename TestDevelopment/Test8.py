from selenium import webdriver
import time
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.action_chains import ActionChains


driver = webdriver.Firefox()
driver.get("https://www.baidu.com/")
# 浏览器的最大化
driver.maximize_window()
# driver.find_element_by_id("kw").send_keys("元旦快乐")
# driver.find_element_by_id("su").click()
b = driver.find_element_by_id("su")
# 双击
# ActionChains(driver).double_click(b).perform()
# time.sleep(5)
# 右击
ActionChains(driver).context_click(b).perform()
# Ctrl+A   Ctrl+C  Ctrl+X
# 用剪贴的方式clear掉文本框中的输入内容
# driver.find_element_by_id("kw").send_keys(Keys.CONTROL, 'a')
# time.sleep(3)
# driver.find_element_by_id("kw").send_keys(Keys.CONTROL, 'x')
# time.sleep(4)
#
# driver.find_element_by_id("kw").send_keys("2022")
# driver.find_element_by_id("su").click()

time.sleep(6)
driver.quit()
