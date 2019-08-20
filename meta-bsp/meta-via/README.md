# meta-via

Yocto BSP layer for VIA i.MX6 serial boards  
[Small Form Factor PCs](https://www.viatech.com/en/systems/small-form-factor-pcs/), 
[Industrial Fanless PCs](https://www.viatech.com/en/systems/industrial-fanless-pcs/)

# Dependencies

This layer depends on:

* alios-bsp-sdk
* meta-freescale

# Configure Environment

1. Copy bblayers_artigoa820.conf to /build/conf/bblayer.conf
2. Copy local_artigoa820.conf to /build/conf/local.conf

# Quick Start

1. source oe-init-build-env
2. Follow section "Configure Environment"
3. bitbake [IMAGE]
   * core-image-via (run time file system)
     * ppp, python, minicom, pciutils,
     * usbutils, alsa-utils, imx-rs485-tool
   * core-image-initramfs (ramdisk for SD installer)
     * parted, dosfstools, e2fsprogs

# Reflash File System
* Build SD card image
  * bitbake core-image-via
  * goto path /build/tmp/deploy/images/[MACHINE]/sd_installer
  * run command: sudo ./mk_sd_installer.sh /dev/sdx --yocto
    (sdx, node of sd device, exp /dev/sdb)
  * switch boot device to u-SD (open the cover on the bottom of the system)
  * insert SD card and power up the system
  * login account: root
* Build SD card installer for flash file system to eMMC
  * bitbake core-image-via core-image-initramfs
  * goto path /build/tmp/deploy/images/[MACHINE]/sd_installer
  * run command: sudo ./mk_sd_installer.sh /dev/sdx
  * switch boot device to u-SD (open the cover on the bottom of the system)
  * insert SD card and power up the system
  * login account: root
  * cd /mnt/mmcblk1p2
  * run command: ./reflash_system.sh
  * run command: shutdown -P 0 (after "Finish. All successed.")
  * remove SD card
  * switch boot device to SPI (open the cover on the bottom of the system)
  * power up the system
