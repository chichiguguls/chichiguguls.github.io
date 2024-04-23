import request from '@/utils/request'

// 查询资产分类列表
export function listSort(query) {
  return request({
    url: '/wzh/sort/list',
    method: 'get',
    params: query
  })
}

// 查询资产分类详细
export function getSort(id) {
  return request({
    url: '/wzh/sort/' + id,
    method: 'get'
  })
}

// 新增资产分类
export function addSort(data) {
  return request({
    url: '/wzh/sort',
    method: 'post',
    data: data
  })
}

// 修改资产分类
export function updateSort(data) {
  return request({
    url: '/wzh/sort',
    method: 'put',
    data: data
  })
}

// 删除资产分类
export function delSort(id) {
  return request({
    url: '/wzh/sort/' + id,
    method: 'delete'
  })
}
