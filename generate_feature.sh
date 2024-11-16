#!/bin/bash

rootFolder="`pwd`"

kotlin "$rootFolder/.templates/generator.kts" --env "$rootFolder/.templates/mpp/.env" -o "$rootFolder/features" -ex "kt" "$rootFolder/.templates/mpp/{{\$module_name}}"
