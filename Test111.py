from selenium import webdriver
import time

# 获得浏览器的驱动
driver = webdriver.Firefox()
# 打开需要访问的web页面
driver.get("https://www.baidu.com/")
driver.find_element_by_css_selector("#kw").send_keys("蒲公英的约定")
driver.implicitly_wait(10)
driver.find_element_by_css_selector("#su").submit()
time.sleep(3)
# driver.find_element_by_id("kw").send_keys("闪亮的火火")
# driver.find_element_by_id("su").submit()
# driver.implicitly_wait(10)
driver.quit()
# time.sleep(8)
# # 清楚浏览器的内容
# driver.find_element_by_css_selector("#kw").clear()
# time.sleep(3)
# driver.find_element_by_css_selector("#kw").send_keys("闪亮的火火")
# driver.find_element_by_id("su").submit()

# xpath
# driver.find_element_by_xpath("//*[@id='kw']").send_keys("雪中")
# driver.find_element_by_xpath("//*[@id='su']").click()
# cssselector

#用id定位
# driver.find_element_by_id("kw").send_keys("六一儿童节")
# driver.find_element_by_id('su').click()
# 用name定位
# driver.find_element_by_name("wd").send_keys("王心凌")
# driver.find_element_by_id("su").click()
#class-name
# driver.find_element_by_class_name("s_ipt nobg_s_fm_hover").send_keys("张天爱")
# driver.find_element_by_class_name("btn self-btn bg s_btn btn_h btnhover").click()
# link text
# driver.find_element_by_link_text("新闻").click()
# prtial link text
# driver.find_element_by_partial_link_text("hao").click()
# tag name
# driver.find_element_by_tag_name("input").send_keys("雅安")
# driver.find_element_by_tag_name("input").click()



