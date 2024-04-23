import request from '@/utils/request'

// 查询资产信息列表
export function listAssets(query) {
  return request({
    url: '/jyf/assets/list',
    method: 'get',
    params: query
  })
}

// 查询资产信息详细
export function getAssets(id) {
  return request({
    url: '/jyf/assets/' + id,
    method: 'get'
  })
}

// 新增资产信息
export function addAssets(data) {
  return request({
    url: '/jyf/assets',
    method: 'post',
    data: data
  })
}

// 修改资产信息
export function updateAssets(data) {
  return request({
    url: '/jyf/assets',
    method: 'put',
    data: data
  })
}

// 删除资产信息
export function delAssets(id) {
  return request({
    url: '/jyf/assets/' + id,
    method: 'delete'
  })
}
