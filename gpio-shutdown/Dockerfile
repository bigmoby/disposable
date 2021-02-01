ARG BUILD_FROM=hassioaddons/debian-base:3.2.3
# hadolint ignore=DL3006
FROM ${BUILD_FROM}

# Set shell
SHELL ["/bin/bash", "-o", "pipefail", "-c"]

# Setup base system
ARG BUILD_ARCH=amd64
# hadolint ignore=SC2181
RUN \
    apt-get update \
    \
    && apt-get install -y --no-install-recommends \
        build-essential=12.6 \
        git=1:2.20.1-2+deb10u3 \
        libraspberrypi-dev \
        raspberrypi-kernel-headers \
    \
    && git clone --branch "master" "https://github.com/adafruit/Adafruit-GPIO-Halt" /tmp/adafruit-gpio \
    \
    && cd /tmp/adafruit-gpio \
    && make \
    && make install \
    \
    && rm -f -r /tmp/* \
    \
    && apt-get purge -y --auto-remove \
        build-essential 

# Copy root filesystem
COPY rootfs /

# Build arguments
ARG BUILD_ARCH
ARG BUILD_DATE
ARG BUILD_REF
ARG BUILD_VERSION

# Labels
LABEL \
    io.hass.name="GPIO Shutdown" \
    io.hass.description="Home Assistant GPIO add-on to support shutdown or reboot command" \
    io.hass.arch="${BUILD_ARCH}" \
    io.hass.type="addon" \
    io.hass.version=${BUILD_VERSION} \
    maintainer="Fabio Bigmoby Mauro <https://github.com/bigmoby>" \
    org.opencontainers.image.title="GPIO Shutdown" \
    org.opencontainers.image.description="Home Assistant GPIO add-on to support shutdown or reboot command" \
    org.opencontainers.image.vendor="Home Assistant Bigmoby Add-ons" \
    org.opencontainers.image.authors="Fabio Bigmoby Mauro <https://github.com/bigmoby>" \
    org.opencontainers.image.licenses="MIT" \
    org.opencontainers.image.url="https://addons.community" \
    org.opencontainers.image.source="https://github.com/bigmoby/addon-gpio-shutdown" \
    org.opencontainers.image.documentation="https://github.com/bigmoby/addon-gpio-shutdown/blob/master/README.md" \
    org.opencontainers.image.created=${BUILD_DATE} \
    org.opencontainers.image.revision=${BUILD_REF} \
    org.opencontainers.image.version=${BUILD_VERSION}
