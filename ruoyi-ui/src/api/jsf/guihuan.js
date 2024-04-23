import request from '@/utils/request'

// 查询资产归还列表
export function listGuihuan(query) {
  return request({
    url: '/jsf/guihuan/list',
    method: 'get',
    params: query
  })
}

// 查询资产归还详细
export function getGuihuan(id) {
  return request({
    url: '/jsf/guihuan/' + id,
    method: 'get'
  })
}

// 新增资产归还
export function addGuihuan(data) {
  return request({
    url: '/jsf/guihuan',
    method: 'post',
    data: data
  })
}

// 修改资产归还
export function updateGuihuan(data) {
  return request({
    url: '/jsf/guihuan',
    method: 'put',
    data: data
  })
}

// 删除资产归还
export function delGuihuan(id) {
  return request({
    url: '/jsf/guihuan/' + id,
    method: 'delete'
  })
}
