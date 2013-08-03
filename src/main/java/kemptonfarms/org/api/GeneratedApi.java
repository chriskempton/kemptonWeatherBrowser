package kemptonfarms.org.api;

import com.wordnik.swagger.annotations.*;

import kemptonfarms.org.model.ComplexType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import kemptonfarms.org.api.NotFoundException;

//import javax.ws.rs.core.Response;
//import javax.ws.rs.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * the generated API
 */
@Controller
@RequestMapping(value = "/generated")
@Api(value = "/generated", description = "the generated API")
public class GeneratedApi {

  private GeneratedApiWorker worker;

  public GeneratedApi(){
    worker = new GeneratedApiWorker();
  }
  
  /**
   * run a GET with an integer in the path
   *
   * 
   * 
   * @return ComplexType response
   */
  
  @RequestMapping(value="/path/{pathinput}", method={RequestMethod.GET})
  @ResponseBody
  @ApiOperation(value = "run a GET with an integer in the path", notes = "", responseClass = "ComplexType")
  @ApiErrors(value = { @ApiError(code = 400, reason = "Bad Request"),@ApiError(code = 401, reason = "Unauthorized"),@ApiError(code = 403, reason = "Forbidden"),@ApiError(code = 404, reason = "Not Found"),@ApiError(code = 405, reason = "Method Not Allowed"),@ApiError(code = 408, reason = "Request Timeout"),@ApiError(code = 415, reason = "Unsupported Media Type"),@ApiError(code = 424, reason = "Method Failure"),@ApiError(code = 500, reason = "Internal Server Error"),@ApiError(code = 501, reason = "Not Implemented"),@ApiError(code = 502, reason = "Bad Gateway"),@ApiError(code = 503, reason = "Service Unavailable"),@ApiError(code = 504, reason = "Gateway Timeout")})
  public ComplexType path(
    @ApiParam(value = "some input"
      ,required=true)
    @PathVariable(value = "pathinput")Integer pathinput
    ,HttpServletRequest request, HttpServletResponse response
  ) throws NotFoundException {
      
      return worker.path(
        pathinput
        ,request, response);
      }

  /**
   * run a GET with ?queryinput=string
   *
   * 
   * 
   * @return ComplexType response
   */
  
  @RequestMapping(value="/param", method={RequestMethod.GET})
  @ResponseBody
  @ApiOperation(value = "run a GET with ?queryinput=string", notes = "", responseClass = "ComplexType")
  @ApiErrors(value = { @ApiError(code = 400, reason = "Bad Request"),@ApiError(code = 401, reason = "Unauthorized"),@ApiError(code = 403, reason = "Forbidden"),@ApiError(code = 404, reason = "Not Found"),@ApiError(code = 405, reason = "Method Not Allowed"),@ApiError(code = 408, reason = "Request Timeout"),@ApiError(code = 415, reason = "Unsupported Media Type"),@ApiError(code = 424, reason = "Method Failure"),@ApiError(code = 500, reason = "Internal Server Error"),@ApiError(code = 501, reason = "Not Implemented"),@ApiError(code = 502, reason = "Bad Gateway"),@ApiError(code = 503, reason = "Service Unavailable"),@ApiError(code = 504, reason = "Gateway Timeout")})
  public ComplexType param(
    @ApiParam(value = "some input"
      ,required=true)
    @RequestParam(value = "queryinput"
      ,required=true)
    Integer queryinput
    ,HttpServletRequest request, HttpServletResponse response
  ) throws NotFoundException {
      
      return worker.param(
        queryinput
        ,request, response);
      }

  /**
   * POSTing will use the body as an input object
   *
   * 
   * 
   * @return Boolean response
   */
  
  @RequestMapping(value="/body", method={RequestMethod.POST})
  @ResponseBody
  @ApiOperation(value = "POSTing will use the body as an input object", notes = "", responseClass = "Boolean")
  @ApiErrors(value = { @ApiError(code = 400, reason = "Bad Request"),@ApiError(code = 401, reason = "Unauthorized"),@ApiError(code = 403, reason = "Forbidden"),@ApiError(code = 404, reason = "Not Found"),@ApiError(code = 405, reason = "Method Not Allowed"),@ApiError(code = 408, reason = "Request Timeout"),@ApiError(code = 415, reason = "Unsupported Media Type"),@ApiError(code = 424, reason = "Method Failure"),@ApiError(code = 500, reason = "Internal Server Error"),@ApiError(code = 501, reason = "Not Implemented"),@ApiError(code = 502, reason = "Bad Gateway"),@ApiError(code = 503, reason = "Service Unavailable"),@ApiError(code = 504, reason = "Gateway Timeout")})
  public Boolean body(
    @ApiParam(value = "some input"
      ,required=true)
    @RequestBody(required=true)ComplexType body
    ,HttpServletRequest request, HttpServletResponse response
  ) throws NotFoundException {
      
      return worker.body(
        body
        ,request, response);
      }

  }

