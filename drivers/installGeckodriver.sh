#!/usr/bin/env bash
#This script supports linux and mac installations.
DEFAULT_VERSION="0.21.0"

OS=${1:-linux64}
GECKO_VERSION=${2:-$DEFAULT_VERSION}

die () {
    echo >&2 "$@"
    exit 1
}

[ "$OS" == "linux64" ] || [ "$OS" == "macos" ] || die "First argument must be one of [linux64,macos].  \"$OS\" is not supported"

GECKO_PARENT_DIR="/usr/local/bin/"
GECKO_DOWNLOAD_URL="https://github.com/mozilla/geckodriver/releases/download/v${GECKO_VERSION}/geckodriver-v${GECKO_VERSION}-${OS}.tar.gz"
GECKO_TEMP="/tmp/geckodriver-v${GECKO_VERSION}-${OS}.tar.gz"

wget -N ${GECKO_DOWNLOAD_URL} -P ~/
tar xvzf ~/geckodriver-v${GECKO_VERSION}-${OS}.tar.gz -C ~/
rm ~/geckodriver-v${GECKO_VERSION}-${OS}.tar.gz
sudo mv -f ~/geckodriver ${GECKO_PARENT_DIR}geckodriver
sudo chown root:root ${GECKO_PARENT_DIR}geckodriver
sudo chmod 755 ${GECKO_PARENT_DIR}geckodriver