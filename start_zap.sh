#! /bin/sh

MACOS_ZAP="/Applications/OWASP ZAP.app/Contents/Java/zap.sh"
LINUX_ZAP="/usr/share/ZAP_2.7.0/ZAP_2.7.0/zap.sh"
if [ "$ZAP" == "" ]; then
    if [ -x "$MACOS_ZAP" ]; then
       ZAP="$MACOS_ZAP"
    elif [ -x "$LINUX_ZAP" ]; then
       ZAP="$LINUX_ZAP"
    fi
fi
if [ "$ZAP" == "" ]; then
    echo Could not find Zap >&2
    echo Tried $MACOS_ZAP >&2
    echo Also tried $LINUX_ZAP >&2
    echo If Zap is not installed please install it >&2
    echo If Zap is installed please teach the $0 script how to find it >&2
    exit 1
fi

"$ZAP" -daemon -config api.disablekey=true -port 11000