import request from '@/utils/request'

// 查询资产维修列表
export function listWxsm(query) {
  return request({
    url: '/wxh/wxsm/list',
    method: 'get',
    params: query
  })
}

// 查询资产维修详细
export function getWxsm(id) {
  return request({
    url: '/wxh/wxsm/' + id,
    method: 'get'
  })
}

// 新增资产维修
export function addWxsm(data) {
  return request({
    url: '/wxh/wxsm',
    method: 'post',
    data: data
  })
}

// 修改资产维修
export function updateWxsm(data) {
  return request({
    url: '/wxh/wxsm',
    method: 'put',
    data: data
  })
}

// 删除资产维修
export function delWxsm(id) {
  return request({
    url: '/wxh/wxsm/' + id,
    method: 'delete'
  })
}
