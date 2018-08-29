# Copyright (c) 2018 VIA Technologies, Inc.

SUMMARY = "Generate a minimal rootfs as RAM FS for SD installer"

IMAGE_INSTALL = "packagegroup-core-boot"

inherit core-image

# fstab for auto mount mmcblk1p2
rootfs_update_fstab () {
    install -d ${IMAGE_ROOTFS}/mnt/mmcblk1p2
    install -d ${IMAGE_ROOTFS}/etc/
    install -m 644 ${TOPDIR}/../meta-bsp/meta-via/recipes-via/via-extra/via-extra/fstab ${IMAGE_ROOTFS}/etc/
}

ROOTFS_POSTPROCESS_COMMAND += "rootfs_update_fstab; "

# Remove unwanted images
rootfs_delete_Image () {
    find ${IMAGE_ROOTFS}/boot -name Image* | xargs rm -rf
}

ROOTFS_POSTPROCESS_COMMAND += "rootfs_delete_Image; "

IMAGE_FSTYPES = "${INITRAMFS_FSTYPES}"

#IMAGE_INSTALL += "packagegroup-initramfs"
