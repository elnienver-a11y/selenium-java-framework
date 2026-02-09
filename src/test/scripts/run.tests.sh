#!/usr/bin/env bash
set -euo pipefail

# Go to project root (one level up from /scripts)
cd "$(dirname "$0")/.."

# Defaults (can be overridden by args)
HEADLESS="${HEADLESS:-true}"
BASE_URL="${BASE_URL:-}"
SUITE="${SUITE:-src/test/resources/testng.xml}"

echo "=== Selenium Test Runner ==="
echo "Project: $(pwd)"
echo "Suite:   $SUITE"
echo "Headless:$HEADLESS"
[ -n "$BASE_URL" ] && echo "BaseUrl: $BASE_URL"

# Build Maven args
MVN_ARGS=(-q test "-Dheadless=$HEADLESS")

if [ -n "$BASE_URL" ]; then
  MVN_ARGS+=("-DbaseUrl=$BASE_URL")
fi

# Run
mvn "${MVN_ARGS[@]}"
echo "✅ Done"