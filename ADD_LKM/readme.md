# LKM
## Agregar Módulo de Kernel

Este proyecto proporciona instrucciones sobre cómo agregar un módulo de kernel personalizado a la capa de meta-raspberrypi en el framework Yocto Project.

## Instrucciones

Sigue los pasos a continuación para agregar el módulo de kernel:

1. Ve al directorio de recipientes:
    ```
    $ cd /YOCTO/meta-raspberrypi
    ```

2. Crea la carpeta para el módulo de kernel:
    ```
    $ mkdir -p recipes-kernel/hello-mod/
    ```

3. Crea el archivo de receta del módulo de kernel:
    ```
    $ vim recipes-kernel/hello-mod/hello-mod_1.0.bb
    ```

    ```bitbake
    SUMMARY = "Example of how to build an external Linux kernel module"
    DESCRIPTION = "${SUMMARY}"
    LICENSE = "GPL-2.0-only"
    LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

    inherit module
    
    SRCREV = "e0d28f320d6cb56a719a951e1d4cf7d49b40df4e"
    SRC_URI = " \
        git://github.com/jonathancagua/hello-mod.git;branch=main;protocol=https \
    "
    
    PV = "1.0+git${SRCPV}"
    
    S = "${WORKDIR}/git"
    
    RPROVIDES_${PN} += "kernel-module-hello"
