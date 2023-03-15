import request from "@/utils/request"

const _obj = {}

// DELETE /user/{id} 删除用户信息
_obj.DeleteUser = (id) => {
    return request({
        url: '/user/' + id,
        method: 'delete',
        params:{}
    })
}

// /user/del/batch 删除用户信息 根据ID批量删除对应的用户信息
_obj.DeleteBatchUser = (data) => {
    return request({
        url: '/user/del/batch',
        method: 'post',
        data
    })
}

// GET /user/getall 获取所有用户
_obj.GetAll = () => {
    return request({
        url: '/user/getall',
        method: 'get',
        params: {}
    })
}
// GET /user/page 分页查询用户信息
_obj.Page = (data) => {
    return request({
        url: '/user/page',
        method: 'get',
        params: data
    })
}
// POST /user/save 新增或更新用户信息
_obj.Save = (data) => {
    return request({
        url: '/user/save',
        method: 'post',
        data
    })
}

export default _obj
