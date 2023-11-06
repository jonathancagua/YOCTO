SUMMARY = "A small boot image for LWL learners"
LICENSE = "MIT"
inherit core-image
IMAGE_INSTALL = "packagegroup-core-boot"
#Add our needed applications
IMAGE_INSTALL += "usbutils"
IMAGE_NAME = "jonathan_img"
IMAGE_INSTALL:append = " examplec examplec-doc"
#IMAGE_INSTALL:append = " examplec"
#IMAGE_INSTALL:append = " examplemake"
#IMAGE_INSTALL:append = " examplegit"