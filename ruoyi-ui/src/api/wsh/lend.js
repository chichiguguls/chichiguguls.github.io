import request from '@/utils/request'

// 查询资产借出列表
export function listLend(query) {
  return request({
    url: '/wsh/lend/list',
    method: 'get',
    params: query
  })
}

// 查询资产借出详细
export function getLend(id) {
  return request({
    url: '/wsh/lend/' + id,
    method: 'get'
  })
}

// 新增资产借出
export function addLend(data) {
  return request({
    url: '/wsh/lend',
    method: 'post',
    data: data
  })
}

// 修改资产借出
export function updateLend(data) {
  return request({
    url: '/wsh/lend',
    method: 'put',
    data: data
  })
}

// 删除资产借出
export function delLend(id) {
  return request({
    url: '/wsh/lend/' + id,
    method: 'delete'
  })
}
