SUMMARY = "A small image just capable of allowing a device to boot."

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

#IMAGE_ROOTFS_SIZE ?= "8192"
#IMAGE_ROOTFS_EXTRA_SPACE_append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "" ,d)}"

IMAGE_FSTYPES += "tar.gz"

IMAGE_INSTALL += "packagegroup-via"

# update interfaces
rootfs_update_interfaces () {
    install -d ${IMAGE_ROOTFS}/etc/network
    install -m 644 ${TOPDIR}/../meta-bsp/meta-via/recipes-via/via-extra/via-extra/interfaces ${IMAGE_ROOTFS}/etc/network/
}

ROOTFS_POSTPROCESS_COMMAND += "rootfs_update_interfaces; "
