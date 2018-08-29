# Copyright (C) 2014 Freescale Semiconductor
# Released under the MIT license (see COPING. MIT for the terms)

DESCRIPTION = "VIA package group - extra"
LICENSE = "CLOSED"

inherit packagegroup
RDEPENDS_${PN} = " \
    ppp \
    python \
    minicom \
    pciutils \
    usbutils \
    alsa-utils \
    via-extra \
    imx-rs485-tool \
"
