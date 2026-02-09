#!/usr/bin/env bash
set -euo pipefail

cd "$(dirname "$0")/.."

HEADLESS="${HEADLESS:-true}"
BASE_URL="${BASE_URL:-}"

echo "=== Selenium Test Runner ==="
echo "Project: $(pwd)"
echo "Headless: $HEADLESS"
[ -n "$BASE_URL" ] && echo "BaseUrl:  $BASE_URL"

MVN_ARGS=(test "-Dheadless=$HEADLESS")

if [ -n "$BASE_URL" ]; then
  MVN_ARGS+=("-DbaseUrl=$BASE_URL")
fi

mvn "${MVN_ARGS[@]}"
echo "✅ Done"
