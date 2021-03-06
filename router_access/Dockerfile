ARG BUILD_FROM=ghcr.io/hassio-addons/base/amd64:9.1.2
# hadolint ignore=DL3006
FROM ${BUILD_FROM}

# Set shell
SHELL ["/bin/bash", "-o", "pipefail", "-c"]

# Setup base
# hadolint ignore=DL3003
RUN \
    apk add --no-cache \
        nginx=1.18.0-r13 

# Copy root filesystem
COPY rootfs /

# Build arguments
ARG BUILD_ARCH
ARG BUILD_DATE
ARG BUILD_REF
ARG BUILD_VERSION

# Labels
LABEL \
    io.hass.name="WireGuard Client" \
    io.hass.description="Fast, modern, secure VPN tunnel (Client)" \
    io.hass.arch="${BUILD_ARCH}" \
    io.hass.type="addon" \
    io.hass.version=${BUILD_VERSION} \
    maintainer="Fabio Bigmoby Mauro <https://github.com/bigmoby>" \
    org.opencontainers.image.title="WireGuard Client" \
    org.opencontainers.image.description="Fast, modern, secure VPN tunnel" \
    org.opencontainers.image.vendor="Home Assistant Community Add-ons" \
    org.opencontainers.image.authors="Fabio Bigmoby Mauro <https://github.com/bigmoby>" \
    org.opencontainers.image.licenses="MIT" \
    org.opencontainers.image.url="https://addons.community" \
    org.opencontainers.image.source="https://github.com/bigmoby/addon-wireguard-client" \
    org.opencontainers.image.documentation="https://github.com/bigmoby/addon-wireguard-client/blob/master/README.md" \
    org.opencontainers.image.created=${BUILD_DATE} \
    org.opencontainers.image.revision=${BUILD_REF} \
    org.opencontainers.image.version=${BUILD_VERSION}
