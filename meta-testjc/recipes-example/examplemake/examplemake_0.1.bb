DESCRIPTION = "Simple helloworld application"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://userprog.c \
           file://Makefile \
           file://Readme.txt "

S = "${WORKDIR}"
EXTRA_OEMAKE += "V=1"
CLEANBROKEN = "1"
do_install() {
    oe_runmake install DESTDIR=${D}/usr/bin/
    install -d ${D}${docdir}
    install -m 0644 Readme.txt ${D}${docdir}
}