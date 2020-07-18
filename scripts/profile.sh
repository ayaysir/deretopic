#!/usr/bin/env bash

# 쉬고있는 프로파일 찾기
function find_idle_profile()
{
  RESP_CODE = $(curl -s -o /dev/null -w "%{http_code}" http://localhost/profile)

  if[ ${RESP_CODE} -ge 400] # 400보다 크면 (에러코드)
  then
    CURRENT_PROFILE = real2
  else
    CURRENT_PROFILE = $(curl -s http://localhost/profile)
  fi

  if[ ${CURRENT_PROFILE} == real1 ]
  then
    IDLE_PROFILE = real2
  else
    IDLE_PROFILE = real1
  fi

  echo "${IDLE_PROFILE}"

}

# 쉬고있는 프로파일의 포트번호 찾기
function find_idle_port() {
  IDLE_PROFILE = $(find_idle_profile)

  if[ ${IDLE_PROFILE} == real1 ]
  then
    echo "8081"
  else
    echo "8082"
  fi
}