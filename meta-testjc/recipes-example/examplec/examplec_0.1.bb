DESCRIPTION = "Simple helloworld application"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://userprogra.c \
           file://Readme.txt \
           file://function.c"

S = "${WORKDIR}"

do_compile() {
    ${CC} -DUSE_SYSCALL userprogra.c function.c ${LDFLAGS} -o userprogr
}	

do_install() {
    install -d ${D}${bindir}
    install -m 0755 userprogr ${D}${bindir}
# instala en directorios generales
#IMAGE_INSTALL:append = " examplec examplec-doc"
    install -d ${D}${docdir}
    install -m 0644 Readme.txt ${D}${docdir}
}
#FILES_${PN} += "{bindir}/userprogr"
#FILES_${PN}-dbg += "{bindir}/userprogr ${includedir}/Readme.txt"
#PACKAGES = "${PN}-dbg ${PN}"