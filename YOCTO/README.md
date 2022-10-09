<div align="center">

# YOCTO

Resumen de trabajo final de ***Sistema operativo II***.<br>
Creado por: [Jonathan, Cagua](https://github.com/jonathancagua)<br>

</div>

# Tabla de contenidos 💡

- [Instalacion](#instalacion)
- [Introducción](#introducción)
- [Programas](#programas)
- [Instrucciones](#instrucciones)
- [Licencia](#licencia)

# Instalacion
## Repositorio poky
Se uitliza la version 3.4 de yocto con el nombre **Honister**. Para comenzar, debes clonar el repositorio Poky:

    git clone -b honister git://git.yoctoproject.org/poky poky-honister

Siguiente paso es ingresar a la carpeta creada y hacer pull del repositorio para bajar cambios:

    cd poky-honister
    git pull --all --prune

## Capas meta adicionales
Se debe clonar los siguientes repositorios dentro de ***poky-honister***:

    git clone -b honister git://git.yoctoproject.org/meta-raspberrypi
    git clone -b honister git://git.openembedded.org/meta-openembedded
    git clone -b honister https://github.com/meta-qt5/meta-qt5.git

# Configuracion
Se debe salir de la carpeta **poky-honister** para generar los archivos de compilacion fuera de esta carpeta:

    cd ..
    source poky-honister/oe-init-build-env build_folder

Se crea un nuevo directorio **build_folder** el cual llevaria el nombre dependiendo de que compilacion deseas realizar. Dentro de la carpeta se crea un directorio con el nombre de  **conf** con los siguientes archivos:
 - bblayers.conf
 - local.conf
 - templateconf.cfg

 ## Editando local.conf para simulacion con qemu
 Cambiar la siguiente línea:

    # This sets the default machine to be qemux86-64 if no other machine is selected:
    MACHINE ??= "qemux86-64"

Seleccionamos la maquina para ejecutar yocto con qemu
    
    # This sets the default machine to be qemux86-64 if no other machine is selected:
    MACHINE ??= "qemuarm"
    
 ## Editando local.conf para raspberry
 Cambiar la siguiente línea:

    # This sets the default machine to be qemux86-64 if no other machine is selected:
    MACHINE ??= "qemux86-64"

Dependiendo de la raspberry que quieras utilizar (raspberrypi0, raspberrypi0w, raspberrypi3, raspberrypi3-64, raspberrypi4, raspberrypi4-64)
    
    # This sets the default machine to be qemux86-64 if no other machine is selected:
    MACHINE ??= "raspberrypi4-64"

Añade las siguientes líneas al final:

    IMAGE_FSTYPES = "ext4.xz rpi-sdimg"
    SDIMG_ROOTFS_TYPE = "ext4.xz"

# Bitbake
Dentro de la carpeta **build_folder** ejecutar el siguiente comando para construir una imagen minima.

    bitbake core-image-minimal

En la **[documentación de Yocto](https://docs.yoctoproject.org/ref-manual/images.html)**  encontrarás una breve descripción de las descripciones de imágenes disponibles.

Por ejemplo:

 - core-image-minimal: una pequeña imagen capaz de permitir que un dispositivo arranque.
 - core-image-base: una imagen solo para consola totalmente compatible con el hardware del dispositivo de destino.
 - core-image-full-cmdline: una imagen solo para consola con más funciones completas del sistema de Linux instaladas.

Después de unas horas el BitBake termina y el **sdimg** se muestra en el siguiente directorio:

    /build_folder/tmp/deploy/images/qemuarm

    o

    /build_folder/tmp/deploy/images/raspberrypi4-64

# Qemu
Las máquinas basadas en QEMU permiten realizar pruebas y desarrollos sin necesidad de hardware real.

Actualmente se admiten emulaciones para:

        • ARM
        • MIPS
        • MIPS64
        • PowerPC
        • X86
        • X86_64


Poky proporciona un script 'runqemu' que le permitirá iniciar el QEMU utilizando imágenes generadas por yocto.

El script runqemu se ejecuta como:

    runqemu <machine> <zimage> <filesystem>

donde:

- < machine > es la máquina/arquitectura a utilizar (qemuarm/qemumips/qemuppc/qemux86/qemux86-64)

- < zimage > es la ruta de acceso a un núcleo (e.g. zimage-qemuarm.bin)
- < filesystem > es la ruta a una imagen ext2 (e.g. filesystem-qemuarm.ext2) o un directorio nfs

Las instrucciones completas de uso se pueden ver ejecutando el comando sin especificar opciones.

Dentro de la carpeta construdia **build_folder**
ejecutar el siguiente comando:

    runqemu qemuarm

## Exit QEMU

Salga de QEMU haciendo clic en el icono de apagado o escribiendo Ctrl-C en la ventana de transcripción de QEMU.







