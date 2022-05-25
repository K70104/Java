from selenium import webdriver
import time

driver = webdriver.Chrome()
driver.get("https://www.baidu.com/")
driver.maximize_window()
driver.find_element_by_css_selector("#kw").send_keys("我在他乡挺好的")
driver.find_element_by_css_selector("#su").click()

time.sleep(8)
driver.quit()

# https://registry.npmmirror.com/binary.html?path=chromedriver/99.0.4844.51/


