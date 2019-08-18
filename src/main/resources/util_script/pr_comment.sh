#!/bin/sh

echo "build out"
cat build.out
echo "build out done"
if [ "$TRAVIS_PULL_REQUEST" != "false" ] ; then
    curl -H "Authorization: token ${GITHUB_TOKEN}" -X POST \
    -d "{\"body\": \"$(tail -5 build.out | sed -n -e 'H;${x;s/\n/,/g;s/^,//;p;}'}" \
    "https://api.github.com/repos/${TRAVIS_REPO_SLUG}/issues/${TRAVIS_PULL_REQUEST}/comments"
fi